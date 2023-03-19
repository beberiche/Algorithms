function solution([min_time, min_fee, extra_time, extra_fee], records) {
    var answer = [];
    const [car_map, fee_map] = [new Map(), new Map()];
    for(let i=0; i<records.length; i++) {
        const [curr_time, car_num, check] = records[i].split(" ");
        const time_make_min = curr_time.substring(0,2)*60 + curr_time.substring(3,5)*1;
        if(car_map.has(car_num)) {
            const time_diff = time_make_min - car_map.get(car_num);
            fee_map.has(car_num) ? fee_map.set(car_num, fee_map.get(car_num)+time_diff) : fee_map.set(car_num, time_diff);
            car_map.delete(car_num);
        } else {
            car_map.set(car_num, time_make_min);
        }
    }
    
    for(let key of car_map.keys()) {
        const time_diff = 23*60 + 59 - car_map.get(key);
        fee_map.has(key) ? fee_map.set(key, fee_map.get(key)+time_diff) : fee_map.set(key, time_diff);
        car_map.delete(key);
    }
    
    for(let key of [...fee_map.keys()].sort((a,b)=>a-b)) {
        answer.push(fee_map.get(key) <= min_time ? min_fee : min_fee + Math.ceil((fee_map.get(key)-min_time)/extra_time)*extra_fee);
    }   
    return answer;
}