function solution(genres, plays) {
  var answer = [];
  var album = {}
  for (let i = 0; i < genres.length; i++) {
    if (!album[genres[i]]) {
      album[genres[i]] = {total: plays[i],
idx: [[plays[i], i]]
      }
    } else {
      album[genres[i]].total += plays[i]
      album[genres[i]].idx.push([plays[i], i])
    }
  }

  Object.values(album).sort((n1, n2) => n2.total - n1.total).forEach(genre => {
    if (genre.idx.length > 1) {
      genre.idx.sort((n1,n2) => n1[0] > n2[0] ? n2[0]-n1[0] : n1[0]<n2[0] ? n2[0]-n1[0] : n1[1] > n2[1] ? n2[1]-n1[1]: n1[1]-n2[1])
      answer.push(genre.idx[0][1])
      answer.push(genre.idx[1][1])
    } else {
      answer.push(genre.idx[0][1])
    }
  });
  return answer;
}
console.log(solution(["classic", "pop", "classic", "classic", "pop"],[500, 600, 150, 800, 2500]))