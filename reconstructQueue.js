/**
 * @param {number[][]} people
 * @return {number[][]}
 */
//https://leetcode.com/problems/queue-reconstruction-by-height/
var reconstructQueue = function(people) {
    if(people.length>0){
        let output = new Array(people.length);
        people = people.sort((a,b)=>{
            if(a[0]==b[0]){ //sort by desdening order
                return a[1]-b[1];
            }else{
               return b[0]-a[0]; 
            }
        });
        debugger;
        return people;
    }else{
        return [];
    }
 };

 console.log(reconstructQueue([[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]));