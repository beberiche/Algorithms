function solution(clothes) {
  const obj = {};
  let answer =1;
  for(let i=0; i<clothes.length; i++) obj[clothes[i][1]] = !obj[clothes[i][1]] ? 1 : obj[clothes[i][1]]+=1
  for(const key in obj) answer*=obj[key];
  return --answer;
}
console.log(solution([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]))