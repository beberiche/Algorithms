function solution(a, b, g, s, w, t) {
  let answer = 10e14 * 4;
  const len = g.length;
  
  let st = 1;
  let ed = answer;
  
  const cumulated = (curr_cost, limit) => curr_cost <= limit ? curr_cost : limit;
       
  while(st<=ed) {
      let mid = parseInt((st+ed)/2);
      let [gold,silver,sum] = [0,0,0];
         
      for(let i=0;i<len; i++) {
          let curr_time = mid % (t[i]*2) >= t[i] ? parseInt(mid/(t[i]*2))+1 : parseInt(mid/(t[i]*2));
          
          gold += cumulated(g[i],curr_time*w[i]);
          silver += cumulated(s[i],curr_time*w[i]);
          sum += cumulated(g[i]+s[i],curr_time*w[i]);
        }
      
       if(gold >= a && silver >= b && sum >= a+b) {
          ed = mid-1;
          answer = Math.min(mid,answer)
       } else {
          st = mid+1;
       }
  }
  
  return answer
}
