export default {
  rules: {
    "type-enum": [
      2,
      "always",
      [
        "feat",
        "fix",
        "refactor",
        "docs",
        "test",
        "perf",
        "security",
        "chore",
        "build",
        "ci",
        "style",
      ],
    ],

    "type-case": [2, "always", "lower-case"],

    "subject-case": [
      2,
      "never",
      ["sentence-case", "start-case", "pascal-case", "upper-case"],
    ],

    "subject-empty": [2, "never"],

    "subject-full-stop": [2, "never", "."],

    "header-max-length": [2, "always", 72],
  },
};