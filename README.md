# Shamir Secret Sharing – Polynomial Reconstruction

## Problem Statement

This project reconstructs the **secret key** using **Shamir’s Secret Sharing algorithm**.

We are given:

* `n` roots (shares) in JSON format
* `k` minimum shares required to reconstruct the polynomial
* `k = m + 1`, where `m` is the degree of the polynomial

The goal is to:

1. Parse the JSON input
2. Convert values from different number bases to decimal
3. Reconstruct the polynomial using **Lagrange Interpolation**
4. Compute the secret key, which is the constant term `f(0)`

---

## Approach

1. Read JSON file
2. Extract:

   * `n` (total shares)
   * `k` (minimum shares required)
3. Convert each share:

   * Key → `x`
   * Base-converted value → `y`
4. Use first `k` valid shares
5. Apply Lagrange Interpolation:

[
f(0) = \sum_{i=0}^{k-1} y_i \prod_{j \ne i} \frac{-x_j}{x_i - x_j}
]

6. Output the reconstructed secret key

---

##  Technologies Used

* Java
* BigInteger (for handling very large numbers)
* org.json library (for JSON parsing)
* VS Code

---

## Project Structure

```
ShamirSecret/
│
├── src/
│   └── Main.java
├── input.json
└── README.md
```



## ✅ Sample Output

```
Secret Key: Constant Value
```

---

## Concepts Used

* Shamir Secret Sharing
* Polynomial Interpolation
* Lagrange Interpolation Formula
  

---

##  Notes

* Only `k` shares are required to reconstruct the secret.
* The implementation handles very large integers safely.
* No Python was used as per assignment constraints.

---

## Author

Vinusha V
Placement Assignment – 2026

---
