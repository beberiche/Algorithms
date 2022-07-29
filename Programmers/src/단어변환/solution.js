function solution(begin, target, words) {
  var answer = 0;
  if (!words.includes(target)) {
    return answer;
  }

  let q = [];
  let visited = new Array(words.length);
  visited.fill(false);
  q.push([begin, 0]);

  answer = 123456789;
  while (q.length !== 0) {
    let [currText, num] = q.shift();
    if (currText === target) {
      answer = Math.min(answer, num);
    }
    let charArr = currText.split("");
    outer: for (let i = 0; i < words.length; i++) {
      if (!visited[i]) {
        let compArr = words[i].split("");

        let cnt = 0;
        for (let j = 0; j < charArr.length; j++) {
          if (compArr[j] !== charArr[j]) {
            cnt++;
            if(cnt >= 2) continue outer;
          }
        }

        //cnt += Math.abs(charArr.length - compArr.length);
        
        visited[i] = true;
        q.push([words[i], num + 1]);
        
      }
    }
  }

  return answer;
}

console.log(solution("hit", "cog", ["hot", "dot", "lot", "log", "cog"]));