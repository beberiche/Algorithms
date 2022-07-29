function solution(board) {
  const COST100 = 100;
  const COST500 = 500;

  const N = board.length;

  const dr = [0, -1, 0, 1];
  const dc = [1, 0, -1, 0];

  const dist = new Array(N);
  const visited = new Array(N);
  for (let i = 0; i < N; i++) {
    dist[i] = new Array(N);
    for (let j = 0; j < N; j++) {
      dist[i][j] = new Array(4);
      dist[i][j].fill(Infinity);
    }
  }


  const q = [];
  // [0] = r;
  // [1] = c;
  // [2] = dir;
  // [3] = cost;
  q.push([0, 0, 0, 0]);
  q.push([0, 0, 3, 0])

  while (q.length) {
    const [currR, currC, currDir, currCost] = q.shift();

    if (currR === N - 1 && currC === N - 1) {
      return currCost;
    }

    for (let d = 0; d < 4; d++) {
      const nr = currR + dr[d];
      const nc = currC + dc[d];

      if (nr < 0 || nc < 0 || nr >= N || nc >= N)
        continue;

      if (board[nr][nc])
        continue;

      let nCost = d === currDir ? currCost + COST100 : currCost + COST100 + COST500;

      if (dist[nr][nc][d] >= nCost) {
        dist[nr][nc][d] = nCost;
        q.push([nr, nc, d, nCost]);
        q.sort((n1, n2) => n1[3] - n2[3]);
      }
    }
  }
}