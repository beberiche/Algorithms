function solution(n) {
  var answer = '';
  let num = [4,1,2];
  while(n>0) {
      answer = num[n%3] + answer;
      n = n%3 === 0 ? n/3 -1 : parseInt(n/3);
  }
  return answer;
}