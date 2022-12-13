let answer = 0;
function solution(citations) {
  citations.sort((a,b)=>a-b);
  findHIdx(citations,0,citations.length)
  return answer;
}

function findHIdx(citations,st,ed) {
  if(st>ed) return;
  
  const mid = Math.floor((st+ed)/2);

  let cnt1 = 0;
  let cnt2 = 0;
  for(const n of citations) {
      if(n>=mid) cnt1++;
      if(n<=mid) cnt2++;
  };
  
  if(cnt1>=mid && cnt2<=mid) {
    answer = Math.max(answer, mid);
    findHIdx(citations,mid+1,ed);
  } else {
    findHIdx(citations,st,mid-1);
  }
}