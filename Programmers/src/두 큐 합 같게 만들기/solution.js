// function solution(queue1, queue2) {
//   // 어디에도 합을 정수로 지정한다는 말은 없다.
//   // q1, q2가 똑같으려면, q1+q2의 총합은 짝수여야만 한다.
//   let [sum1,sum2] = [queue1.reduce((a,b)=>a+b),queue2.reduce((a,b)=>a+b)]
//   if((sum1+sum2)%2!=0) return -1;
  
//   let mid = (sum1+sum2) / 2;
  
//   let cnt = 0;
//   let max = queue1.length *3;
//   while(cnt < max) {
//      if(queue1.length === 0 || queue2.length === 0) return -1;
//      if(sum1 === mid && sum2 === mid) return cnt;
//      if(sum1 < mid) {
//           const temp = queue2.shift();
//           queue1.push(temp);
//           sum1 += temp;
//           sum2 -= temp;
//           cnt++;
//       } else if(sum1 > mid) {
//           const temp = queue1.shift()
//           queue2.push(temp);
//           sum1 -= temp;
//           sum2 += temp;
//           cnt++
//       } 
//   }
//   return -1;
// }


function solution(queue1, queue2) {
  const arr = [...queue1, ...queue2]
  const sum = arr.reduce((a,b)=>a+b);
  if(sum%2 !=0) return -1;
  let [mid, st, ed, cnt] = [parseInt(sum/2),0,queue1.length, 0];
  let queue1Sum = queue1.reduce((a,b)=>a+b);
  while(st < ed) {
    if(queue1Sum === mid) return cnt;
    queue1Sum < mid ? queue1Sum+=arr[ed++] : queue1Sum-=arr[st++];
    cnt++;
  }
  return -1;
}
console.log(solution([3, 2, 7, 2], [4, 6, 5, 1]))

