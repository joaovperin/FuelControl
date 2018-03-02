var gulp = require('gulp');
var sass = require('gulp-sass');
var cleanCss = require('gulp-clean-css');
var rename = require('gulp-rename');

var paths = {
  sass: ['./scss/**/*.scss']
};

gulp.task('default', ['sass']);

gulp.task('sass', function(done) {
  gulp.src('./scss/ionic.app.scss')
    .pipe(sass())
    .on('error', sass.logError)
    .pipe(gulp.dest('./www/css/'))
    .pipe(cleanCss({
      keepSpecialComments: 0
    }))
    .pipe(rename({ extname: '.min.css' }))
    .pipe(gulp.dest('./www/css/'))
    .on('end', done);
});

gulp.task('watch', ['sass'], function() {
  gulp.watch(paths.sass, ['sass']);
});
/**
 * 
 * 
 * var gulp = require('gulp');
var concat = require('gulp-concat');
var babel = require('gulp-babel');
var sourcemaps = require('gulp-sourcemaps');
var changed = require('gulp-changed');
var plumber = require('gulp-plumber');

var paths = {
  modulos: ['./www/modulos/**\/*.js', './www/modulos/\* \*\/*.html', '!./www/dist/\* \*\/\*']
};

// Build de arquivos js
gulp.task('build', function () {
  var pathES6 = ['./www/modulos/*\*\/config.js', './www/modulos/*\*\/\\\*.js', '!./www/modulos/app.js'];
  var pathBuild = ['./www/dist/*\*\/config.js', './www/dist/**\/*.js', '!./www/dist/pedidomobile.js'];
  return gulp.src(pathES6)
          .pipe(sourcemaps.init())
          .pipe(changed('./www/dist'))
          .pipe(plumber())
          .pipe(babel({
              presets: ['es2015']
          }))
          .pipe(sourcemaps.write())
          .pipe(gulp.dest('./www/dist')).on('end', function () {
      return gulp.src(pathBuild)
              .pipe(sourcemaps.init({loadMaps: true}))
              .pipe(concat('pedidomobile.js'))
              .pipe(sourcemaps.write())
              .pipe(gulp.dest('./www/dist'));
  });
});

// Watch - Verifica os arquivos alterados e realiza o build
gulp.task('watch', function () {
  gulp.watch(paths.modulos, ['build']);
});

// Live Reload
gulp.task('serve', function () {
  gulp.start('watch');
});

// Tarefa default = Watch
gulp.task('default', ['watch']);

*/