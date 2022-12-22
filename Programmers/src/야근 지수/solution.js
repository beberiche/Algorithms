function solution(n, works) {
  works.sort((a,b)=> b-a);
  let cnt = n;
  while(--cnt>=0) {
    if(works[0] == 0) break;
    works[0]--;
    let idx = 2;
    if(works[0] < works[1]) {
      while(true) {
        if(works[idx] <= works[0]) {
          let tmp = works[idx-1];
          works[idx-1] = works[0];
          works[0] = tmp;
          break;
        } else if(idx == works.length) {
          works.push(works.shift());
          break;
        } 
        idx++;
      }
    };
  }
  let ans = 0;
  for(let num of works) ans += (num*num);
  return ans;
}
console.log(solution(4, [4,3,3]));