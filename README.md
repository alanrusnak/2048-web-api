#2048 game engine accessible via simple Web API

2048 game engine written in Java with Spring and SpringBoot frameworks.

See it live on http://alanrusnak.com/2048


##API
Create new game:
```
http://localhost:8080/2048/new/
```
Get game state:
```
http://localhost:8080/2048/{game-id}/
```

Make a move:
```
http://localhost:8080/2048/{game-id}/0 //move up
http://localhost:8080/2048/{game-id}/1 //move right
http://localhost:8080/2048/{game-id}/2 //move down
http://localhost:8080/2048/{game-id}/3 //move left
```
All requests result in a JSON response in this format:
```
{ 
"id": "3943a369-31a8-4b15-92b0-744660deab64", 
"score": 4, 
"board": { 
          "tiles": [ [ 0, 0, 0, 0 ], [ 0, 0, 2, 0 ], [ 0, 0, 0, 0 ], [ 0, 4, 0, 0 ] ] 
          }, 
"gameOver": false 
}
```


