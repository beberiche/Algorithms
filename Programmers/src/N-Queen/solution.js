let ans = 0;
let arr;
function solution(n) {
  arr = new Array(n).fill(999);
  DFS(n,0)
  return ans;
}

function DFS(n, r) {
  if(r>=n) {
    ans++;
    return;
  }

  for(let c=0; c<n; c++) {
    if(check1(c) && check2(r,c)) {
      arr[c] = r;
      DFS(n, r+1);  
      arr[c] = 999;  
    }
  }
}

function check1(c) {
  return arr[c] == 999;
}

function check2(r,c) {
  for(let i=0; i<arr.length; i++) {
    if(Math.abs(r-arr[i]) == Math.abs(c-i)) {
      return false;
    };
  }
  return true;
}

console.log(solution(4));