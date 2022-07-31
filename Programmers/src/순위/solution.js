function solution(n, results) {
  var answer = 0;
  const boxesWin = new Array(n+1);
  const boxesLose = new Array(n+1);

  for(let i=1; i<=n; i++) {
      boxesWin[i] = new Array();
      boxesLose[i] = new Array();
  }
  
  for(let i=0; i<results.length; i++) {
      boxesWin[results[i][0]].push(results[i][1])
      boxesLose[results[i][1]].push(results[i][0])
  }


  for(let i=1; i<=n; i++) {
    if(BFS(boxesWin,i,visitedInit(n)) + BFS(boxesLose,i,visitedInit(n)) === n-1) 
      answer++;
  }
  
  return answer;
}

function BFS(boxes, idx,visited) {
  const q = [idx];
  visited[idx] = true;
  let cnt = 0;
  while(q.length) {
    const currIdx = q.shift();
    for(const to of boxes[currIdx]) {
      if(visited[to])
        continue;
      
      visited[to] = true;
      q.push(to);
      cnt++;
    }  
  }
  return cnt; 
}

function visitedInit(n) {
  return new Array(n+1).fill(false);
}