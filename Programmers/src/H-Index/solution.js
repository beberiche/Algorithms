let answer = 0;
function solution(citations) {
  citations.sort((a,b)=>a-b);
  findHIdx(citations,0,citations.length)
  return answer;
}

function findHIdx(citations,st,ed) {
  if(st>ed) return;
  
  const mid = Math.floor((st+ed)/2);

  let cnt = 0;
  for(const n of citations) n>=mid && cnt++;
  
  if(cnt>=mid) {
    answer = Math.max(answer, mid);
    findHIdx(citations,mid+1,ed);
    return;
  } 
  findHIdx(citations,st,mid-1);
}

console.log(solution([3,0,6,1,5]));