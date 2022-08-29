function solution(rows, columns, queries) {
  let map = new Array();
  let num = 1;
  for (let i = 0; i < rows; i++) {
    map.push(new Array(columns));
    for (let j = 0; j < columns; j++) map[i][j] = num++;
  }

  let ans = new Array();
  for (let i = 0; i < queries.length; i++) {
    const [r1, c1, r2, c2] = [queries[i][0] - 1, queries[i][1] - 1, queries[i][2] - 1, queries[i][3] - 1];
    let [prevNum, nextNum, minNum] = [map[r1][c1], 0, map[r1][c1]];
    for (let c = c1; c < c2; c++) {
      nextNum = map[r1][c + 1];
      map[r1][c + 1] = prevNum;
      prevNum = nextNum;
      minNum = Math.min(minNum, prevNum);
    }
    for (let r = r1; r < r2; r++) {
      nextNum = map[r + 1][c2];
      map[r + 1][c2] = prevNum;
      prevNum = nextNum;
      minNum = Math.min(minNum, prevNum);
    }
    for (let c = c2; c > c1; c--) {
      nextNum = map[r2][c - 1];
      map[r2][c - 1] = prevNum;
      prevNum = nextNum;
      minNum = Math.min(minNum, prevNum);
    }
    for (let r = r2; r > r1; r--) {
      nextNum = map[r - 1][c1];
      map[r - 1][c1] = prevNum;
      prevNum = nextNum;
      minNum = Math.min(minNum, prevNum);
    }
    ans.push(minNum);
  }
  return ans;
}





console.log(solution(3, 3, [[1, 1, 2, 2], [1, 2, 2, 3], [2, 1, 3, 2], [2, 2, 3, 3]]));