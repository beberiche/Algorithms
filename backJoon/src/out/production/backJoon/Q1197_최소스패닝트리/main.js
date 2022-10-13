const fs = require("fs")
let [info, ...res] = fs.readFileSync("/dev/stdin").toString().trim().split('\n');

class Edge {
  constructor(to, cost) {
    this.to = to
    this.cost = cost
  }
}

const [V,E] = info.split(" ").map(str => str*1);

const edgeList = new Array(V+1)
for(let i=1; i<=V; i++) 
  edgeList[i] = new Array()

for(let i=1; i<E; i++) {
  const [st,ed,cost] = res[i-1].split(" ").map(str => str*1)
  
  edgeList[st].push(new Edge(ed,cost));
  edgeList[ed].push(new Edge(st,cost));
}

const visited = new Array(V+1);

const pq = [];
const sorting = () => pq.sort((n1,n2) => n1.cost-n2.cost);

edgeList[1].forEach((edge)=>{pq.push(edge)})
visited[1]= true;
sorting()

let ans = 0;

while(pq.length) {
  const {to, cost} = pq.shift();
  if(visited[to])
    continue;
  
  ans += cost;
  edgeList[to].forEach((edge) => pq.push(edge))
  visited[to] = true;
  sorting()
}

console.log(ans)

