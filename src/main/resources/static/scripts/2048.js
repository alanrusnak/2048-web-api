var gameId;

function newGame() {
   $.ajax({
           url: "/2048/new"
       }).then(function(data) {
          gameId = data.id;
          $('.game-id').append(data.id);
          $('.game-score').append(data.score);
          $('#tile-row-one').text(data.board.tiles[0]);
          $('#tile-row-two').text(data.board.tiles[1]);
          $('#tile-row-three').text(data.board.tiles[2]);
          $('#tile-row-four').text(data.board.tiles[3]);
          console.log(data);
       });
};

function displayData(data){
$('.game-score').text("Score: " + data.score);
          $('#tile-row-one').text(data.board.tiles[0]);
          $('#tile-row-two').text(data.board.tiles[1]);
          $('#tile-row-three').text(data.board.tiles[2]);
          $('#tile-row-four').text(data.board.tiles[3]);
          console.log(data);
}

function move(direction) {
   $.ajax({
           url: "/2048/" + gameId + "/" + direction
       }).then(function(data) {
          displayData(data);
       });
};
