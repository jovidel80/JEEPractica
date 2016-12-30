/**
 * Created by joliveros on 28/12/2016.
 */
var game = new Phaser.Game(800, 600, Phaser.AUTO, 'image', {preload: preload, create: create, update: update, render: render});

function preload() {
    game.load.image('firstaid', '../assets/phaser/firstaid.png');
}

var sprite;

function create() {
    game.physics.startSystem(Phaser.Physics.ARCADE);
    sprite = game.add.sprite(game.world.centerX, game.world.centerY, 'firstaid');
    sprite.anchor.set(0.5);
    game.physics.arcade.enable(sprite);
}

function update() {
    if (game.physics.arcade.distanceToPointer(sprite, game.input.activePointer) > 8) {
        game.physics.arcade.moveToPointer(sprite, 300);
    } else {
        sprite.body.velocity.set(0);
    }
}

function render() {
    game.debug.inputInfo(32, 32);
}