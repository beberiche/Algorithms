function solution(n, times) {
  let [st,ed] = [1, n*times.sort((a,b)=> a-b)[times.length - 1]];
  while(st <= ed) {
      let mid = parseInt((st+ed)/2);
      times.reduce((acc,currV)=> acc + parseInt(mid/currV),0)>=n ? (ed = mid-1) : (st = mid+1)
  }
  return st
}

console.log(solution(6, [7,10]))