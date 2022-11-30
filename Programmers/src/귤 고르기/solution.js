function solution(k, tangerine) {
  let map = {};
  
  tangerine.forEach((item)=> map[item] = (map[item] || 0) +1);

  const sortArr = Object.values(map).sort((a,b) => b-a)

  let cnt = 0;
  while(k>0) {
    cnt++;
    k-=sortArr.splice(0,1)[0];
  }
 

  return cnt;
}


console.log(solution(6, [1,3,2,5,4,5,2,3]));