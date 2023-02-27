function solution(n) {
  const arr = [0, 3, 11];
  let [sum, div] = [14, 1e9 + 7];
  for (let i = 3; i <= n / 2; i++) {
    const prev = arr[i - 1];
    arr[i] = (prev * 3 + ((sum - prev) * 2 + 2)) % div;
    sum += arr[i];
  }
  return arr[n / 2] % div;
}
