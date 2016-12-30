/**
 * Created by joliveros on 27/12/2016.
 */
var game = new Phaser.Game(1200, 433, Phaser.AUTO, 'image', {preload: preload, create: create});

function preload() {
    game.load.image('simpsons', 'assets/los-simpson.jpg');
}

function create() {
    var image = game.add.sprite(0, 0, 'simpsons');
    game.physics.enable(image, Phaser.Physics.ARCADE);
    image.body.velocity.x = 150;
}
