package com.utn.MutantChecker.services;

import com.utn.MutantChecker.entities.Dna;
import com.utn.MutantChecker.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MutantServices {
    @Autowired
    private final DnaRepository dnaRepo;
    private static final int sequenceLength = 4;

    public MutantServices(DnaRepository dnaRepo) {
        this.dnaRepo = dnaRepo;
    }

    public boolean isMutant(String[] dna) {
        int sequenceCount = 0;
        int n = dna.length;

        // Validamos la estructura de la matriz (NxN)
        for (String row : dna) {
            if (row.length() != n) return false;  // La matriz debe ser NxN
        }

        // Convertimos el array de Strings en una matriz de caracteres
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = dna[i].toCharArray();
        }

        // Buscamos secuencias de 4 letras consecutivas en cada dirección
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (hasSequence(matrix, i, j)) {
                    sequenceCount++;
                    if (sequenceCount > 1) return true;  // Si hay más de una secuencia, es mutante
                }
            }
        }

        return false;  // No se encontraron suficientes secuencias
    }


    public boolean hasSequence(char[][] matrix, int row, int col) {
        char letter = matrix[row][col];

        // Direcciones: horizontal, vertical, diagonal (izq-derecha y derecha-izq)
        return checkDirection(matrix, row, col, 0, 1, letter) ||  // Horizontal
                checkDirection(matrix, row, col, 1, 0, letter) ||  // Vertical
                checkDirection(matrix, row, col, 1, 1, letter) ||  // Diagonal derecha
                checkDirection(matrix, row, col, 1, -1, letter);   // Diagonal izquierda
    }


    public boolean checkDirection(char[][] matrix, int row, int col, int rowInc, int colInc, char letter) {
        int count = 0;
        for (int i = 0; i < sequenceLength; i++) {
            int newRow = row + i * rowInc;
            int newCol = col + i * colInc;
            if (newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix.length ||
                    matrix[newRow][newCol] != letter) {
                return false;
            }
            count++;
        }
        return count == sequenceLength;
    }


    public boolean analyzeData(String[] dna) {
        String dnaSequence = String.join(",",dna);

        //Verificamos si el adn ya existe en la base de datos
         Optional<Dna> existingDna = dnaRepo.findBySequence(dnaSequence);
        if (existingDna.isPresent()){
            return existingDna.get().isIsmutant();
        }
        boolean ismutant = isMutant(dna);
        Dna dnaEntity = Dna.builder().dna(dnaSequence).ismutant(ismutant)
                .build();
        dnaRepo.save(dnaEntity);
        return isMutant(dna);
    }
}


