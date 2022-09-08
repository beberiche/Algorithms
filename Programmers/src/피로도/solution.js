let sel;
let visited;
let ans = 0;
function solution(k, dungeons) {
  const len = dungeons.length;
  sel = new Array(len).fill(0);
  visited = new Array(len).fill(false);
  perm(0,len, dungeons,k);
  return ans;
}

function perm(idx,len, dungeons,k) {
  if(idx>=len) {
    ans = Math.max(calc(k), ans);   
    return;
  }

  for(let i=0; i<len; i++) {
    if(visited[i]) continue;
    sel[idx] = dungeons[i];
    visited[i] = true;
    perm(idx+1, len, dungeons,k);
    visited[i] = false;
  }
}

function calc(k) {
  let curr_k = k;
  let cnt = 0;
  for(let i=0; i<sel.length; i++) {
    if(curr_k>=sel[i][0]) {
      curr_k -= sel[i][1];
      cnt++;
    } else break;
  }
  return cnt;
}
solution(80, [[80,20],[50,40],[30,10]])