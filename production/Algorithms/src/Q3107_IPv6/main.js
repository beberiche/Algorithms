const input = require("fs").readFileSync("./input.txt").toString().trim();
const check = input.includes("::");
if (check) {
  const converting = input.indexOf("::") == 0 ? input.replace("::", "0:").split(":").map((n => n.padStart(4, '0'))) : input.indexOf("::") == input.length - 2 ? input.replace("::", ":0").split(":").map((n => n.padStart(4, '0'))) : input.replace("::", ":0:").split(":").map((n => n.padStart(4, '0')))
  let len = 8 - converting.length;
  for (let i = 0; i < len; i++) converting.splice(converting.lastIndexOf("0000"), 0, "0000")
  console.log(converting.join(":"))
} else console.log(input.split(":").map((n => n.padStart(4, '0'))).join(":"))
