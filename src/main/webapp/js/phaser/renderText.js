/**
 * Created by capitanjovi on 30/12/16.
 */
var game = new Phaser.Game('800', '600', Phaser.CANVAS, 'image', {create: create});

function create() {
    var text = "- phaser -\n with a sprinkle of \n pixi dust.";
    var style = {font: "65px Arial", fill: "#ff0044", align: "center"};

    var t = game.add.text(game.world.centerX - 300, 50, text, style);
}
