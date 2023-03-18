function solution(n, s) {
    if(s/n < 1) return [-1];
    let answer = Array.from(new Array(n), ()=> parseInt(s/n));
    for(let i=s%n, idx=n-1; i>0; i--, idx--) answer[idx]++
    return answer;
}