let compArr;
let num;

function solution(n, words) {
  const countArr = new Array(n+1).fill(0);
  compArr = [];
  num = 0;

  for(const [idx, word] of words.entries()) {
    countArr[num%n+1]++;
    if(idx === 0 || words[idx-1][words[idx-1].length-1] === word[0] && check(word)) next(word)
    else return [num%n+1, countArr[num%n+1]];
  }

  return [0,0];
}

function check(compWord) {
  for(let word of compArr) if(word === compWord) return false;
  return true;
}

function next(word) {
  compArr.push(word);
  num++;
}

console.log(solution(2, 	["hello", "one", "even", "never", "now", "world", "draw"]))