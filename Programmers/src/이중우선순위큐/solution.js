function solution(operations) {
    
  let q = [];
  for(let i=0; i<operations.length; i++) {
      let oper = operations[i].split(" ");
      
      
      oper[0]==="I" ?  oper[1][0] === "-" ?  q.push(oper[1].substring(1, oper[1].length)*-1) : q.push(oper[1]*1) : oper[1] === "-1" ? q.shift() : q.pop()     
      
      q.sort((n1,n2)=> n1-n2);
  }
  
  
  switch(q.length) {
      case 0: 
          return [0,0];    
      case 1:
          return q[0]<0 ? [0,q[0]] : [q[0],0];
      default:
          return [q[q.length-1], q[0]];
  }
}