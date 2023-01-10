function solution(n, k, enemy) {
  if (k >= enemy.length) return enemy.length;
  let l = 0;
  let r = enemy.length;

  let ans = 0;
  function check(pos) {
    let temp = enemy.slice(0, pos).sort((a, b) => b - a);
    let tk = k;
    let sum = temp.reduce((acc, cur) => {
      if (tk > 0) {
        tk--;
        return acc;
      }
      return acc + cur;
    }, 0);
    return sum <= n && tk >= 0;
  }

  while (l <= r) {
    let mid = Math.floor((l + r) / 2);
    if (check(mid)) l = mid + 1;
    else r = mid - 1;
  }
  return r;
}
console.log(solution(7, 3, [4, 2, 4, 5, 3, 3, 1]));
