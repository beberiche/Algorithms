const [spl1, spl2] = require("fs").readFileSync("./input.txt").toString().trim().split("\n").map((el) => el.split(""));
const array = Array.from(Array(spl1.length + 1), () => Array(spl2.length + 1).fill(0))
  for (let j = 1; j <= spl2.length; j++)
    array[i][j] = spl1[i - 1] === spl2[j - 1] ? array[i - 1][j - 1] + 1 : Math.max(array[i][j - 1], array[i - 1][j]);

console.log(array[spl1.length][spl2.length]);