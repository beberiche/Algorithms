function solution(book_time) {
    let book_time_min = book_time.map((el)=> {
        let [st_h, st_m] = el[0].split(":");
        let [ed_h, ed_m] = el[1].split(":");
        let st_time = st_h*1*60 + st_m*1;
        let ed_time = ed_h*1*60 + ed_m*1;
        return [st_time, ed_time];
    })
    book_time_min.sort((a,b)=>a[0]-b[0]);
    const rooms = [book_time_min[0][1]+10];
    for(let i=1; i<book_time_min.length; i++) {
        let curr_time_st = book_time_min[i][0];
        if(rooms[0]>curr_time_st) {
            rooms.push(book_time_min[i][1]+10);
            rooms.sort((a,b)=>a-b);
        } else {
            for(let j=rooms.length-1; j>=0; j--) {
                if(rooms[j]<=curr_time_st) {
                    rooms[j] = book_time_min[i][1]+10;
                    rooms.sort((a,b)=>a-b);
                    break;
                }
            }
        }       
    }
    return rooms.length;
}