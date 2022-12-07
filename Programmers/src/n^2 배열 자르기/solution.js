function solution(n, left, right) {
  let answer = [];
  for(let i=left; i<=right; i++) {
    // 일차원 배열의 idx를 이차원 배열로 변화시키는 경우 : 단 rLen, cLen은 모두 같아야함
    // 해당 일차원 배열의 idx를 2차원 배열의 len으로 나누었을 때 몫이 r 값
    // 해당 일차원 배열의 idx를 2차원 배열의 len으로 나누었을 때 나머지가 c 값
    answer.push(Math.max(Math.floor(i/n),i%n)+1);
  }
  return answer;
}