function solution(progresses, speeds) {
  let q = [];
  for(const [idx, num] of progresses.entries()) {
    const day = Math.ceil((100 - num) / speeds[idx]);
    q.push(day);
  }
  let [currNum, count, ans, sum] = [q[0], 1, [], 0];

  for(let i=1; i<q.length; i++) {
    if(currNum >= q[i]) count++;
    else {    
      currNum = q[i];
      ans.push(count);
      sum+=count;
      count = 1;
    }
  }

  if(sum != q.length) ans.push(count);
  return ans;
}
console.log(solution([95, 90, 99, 99, 80, 99],	[1, 1, 1, 1, 1, 1]))