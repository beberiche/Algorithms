const fs = require("fs")
const [len, vCnt, ...vips] = fs.readFileSync("./input.txt").toString().trim().replaceAll("\r", "").split("\n");
let seat = new Array(len * 1 + 1).fill(1, 0, 2);
for (let i = 2; i <= len * 1; i++) seat[i] = seat[i - 1] + seat[i - 2]
let [ans, currSeat] = [1, 0]
for (let i = 0; i < vCnt * 1; i++) {
  ans *= seat[vips[i] * 1 - currSeat - 1];
  currSeat = vips[i];
}
console.log(ans *= seat[len - currSeat])




