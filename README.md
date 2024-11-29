# Mutants Validator

In this project we are gonna get through the solution to find out if a human is mutant or not, implementing the method required and some extra features

# Requirements

"Magneto needs to recruit as many mutants as possible to be able to fight against the X-Men.
To accomplish this, he has asked us to create a program with a method or function with the following signature:
  boolean isMutant(String[] dna);
This method will receive an array of Strings as a parameter, each representing a row in a (NxN) table with the DNA sequence. 
The characters in the Strings can only be: (A, T, C, G), which represent each nitrogenous base in DNA.
We will know a human is mutant, if we found out a secuence of 4 equal letters (horizontally, vertically or diagonally) more than once."

#Sequence Diagram
Click the link below to see the sequence diagram for a POST /mutant request
[Diagrama de secuencia - Mutantes.pdf](https://github.com/user-attachments/files/17953391/Diagrama.de.secuencia.-.Mutantes.pdf)

# Execution of the Project
The project has been deployed on Render and it can be access by following the links below

- GET  https://mutantes-magento-w21.onrender.com/mutant/get     : To get all the registers
- GET  https://mutantes-magento-w21.onrender.com/mutant/stats   : To get all the stats from people who has been scanned
- POST https://mutantes-magento-w21.onrender.com/mutant/mutant  : Using POSTMAN and sending a JSON with all the features required

# Endpoints
- POST /mutant : Recives a JSON with a string sequence containing the ADN to analyze
{
    "dna": [
        "ATGCGA",
        "CAGTGC",
        "TTATGT",
        "AGAAGG",
        "CCCCTA",
        "TCACTG"
    ]
}
- GET /stats : Returns a JSON with the following information
{
    "count_mutant_dna": 40,
    "count_human_dna": 100,
    "ratio": 0.4
}

# ADN Examples
- MUTANT Matrix
{
    "dna": [
      "ATGCGA",
      "CAGTGC",
      "TTATGT",
      "AGAAAG",
      "CCCCTA",
      "TCACTG"
    ]
}
- NO MUTANT Matrix
{
    "dna": [
      "ATGGTG",
      "GTCTTA",
      "AATTGG",
      "ACTAGT",
      "GGATTC", 
      "AGGCAA"
    ]
}



