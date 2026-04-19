# Playfair Cipher in Java

## Overview

This project implements the **Playfair Cipher**, a classical encryption technique that encrypts text in pairs of letters using a 5x5 matrix generated from a keyword.

## Features

* Key preprocessing (removes duplicates, converts J → I)
* Automatic 5x5 matrix generation
* Text preparation into valid letter pairs
* Encryption and decryption support
* Console-based user input/output

## How It Works

1. The user provides a **key**.
2. A **5x5 matrix** is generated using the key and remaining alphabet letters.
3. The input text is:

   * Converted to uppercase
   * Cleaned (non-letters removed, J → I)
   * Split into pairs
4. Encryption rules:

   * Same row → shift right
   * Same column → shift down
   * Rectangle → swap columns
5. Decryption applies the reverse rules.

## Usage

### Compile

```bash
javac PlayfairCipher.java
```

### Run

```bash
java PlayfairCipher
```

### Example

```
Shkruaj key: MONARCHY

Matrica 5x5:
M O N A R
C H Y B D
E F G I K
L P Q S T
U V W X Z

Shkruaj mesazhin: HELLO

Encrypted: ...
Decrypted: ...
```

## Project Structure

* `PlayfairCipher.java` – Main class with all logic

## Notes

* The letter **J is treated as I**
* If a pair has duplicate letters, **X** is inserted
* If the text length is odd, **X** is added at the end

## Author

Student project – Playfair Cipher implementation in Java