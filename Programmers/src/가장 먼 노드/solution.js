function solution(n, edge) {
  var answer = 0;
  
  let map = new Array(n) 
  let vertex = new Array(n+1)
  let visited = new Array(n+1).fill(false)
  
  for(let i=0; i<vertex.length; i++) {
      vertex[i] = new Array()
      map[i] = new Array()
  }
  
  for(let i=0; i<edge.length; i++) {
      const [curr, to] = edge[i];
      vertex[curr].push(to);
      vertex[to].push(curr);
  }
  
  let q = [[1,0]];
  visited[1] = true;
  
  while(q.length) {
      let [idx, dist] = q.shift()
      
      for(let n of vertex[idx]) {
        if(visited[n]) 
          continue;
        
        visited[n] = true;
        map[dist+1].push(n)
        q.push([n, dist+1])
      }
      

  }
  
  for(let i=map.length-1; i>=0; i--) {
      if(map[i].length) {
          return map[i].length;
      }
  }
}

console.log(solution(6,[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]))