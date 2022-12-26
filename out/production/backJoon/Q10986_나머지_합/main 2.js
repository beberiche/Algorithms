const fs = require("fs")
const [line1, line2] = fs.readFileSync("./input.txt").toString().trim().replace("\r", "").split("\n");

const [N, M] = line1.split(" ").map((val)=> val*1);
const remains = line2.split(" ").map((val)=>val*1%M);
const mod = new Array(M).fill(0);

mod[remains[0]]++
for(let i=1; i<N; i++) mod[(remains[i] += remains[i-1])%M]++

let answer = mod[0];
for(let i=0; i<M;i++) answer += mod[i] * (mod[i]-1)/2
console.log(answer)