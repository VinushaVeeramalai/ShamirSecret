# Shamir Secret Reconstruction

Reconstructs a secret from Shamir secret-sharing shares stored in JSON.

## Build & Run

```bash
javac shamir.java
java shamir input1.json
```

Default file is `input1.json` if no argument is given.

## Push to GitHub

1. Install [Git](https://git-scm.com/download/win) if needed.
2. Create a new repository on [GitHub](https://github.com/new) (do not add README).
3. In this folder, run:

```bash
git init
git add shamir.java input1.json input2.json README.md .gitignore
git commit -m "Shamir secret reconstruction"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/YOUR_REPO.git
git push -u origin main
```

Replace `YOUR_USERNAME` and `YOUR_REPO` with your GitHub username and repo name.
