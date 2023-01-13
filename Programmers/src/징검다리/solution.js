function solution(distance, rocks, n) {
  var answer = 0;
  rocks.sort((a, b) => a - b);

  let [l, r] = [0, distance];
  while (l <= r) {
    const mid = Math.floor((l + r) / 2);
    let [tn, pv] = [n, 0];
    for (let i = 0; i < rocks.length; i++)
      rocks[i] - pv < mid ? tn-- : (pv = rocks[i]);

    if (distance - rocks[rocks.length - 1] < mid) tn--;

    if (tn < 0) r = mid - 1;
    else {
      answer = mid;
      l = mid + 1;
    }
  }

  return answer;
}

console.log(solution(25, [2, 14, 11, 21, 17], 2));
