var gulp = require('gulp');
var sass = require('gulp-sass');
var autoprefixer = require('gulp-autoprefixer');
var imagemin = require('gulp-imagemin');

gulp.task('css', function() {
  return gulp.src('./public/src/sass/*.scss')
    .pipe(sass({
      outputStyle: 'expanded'
    }))
    .pipe(autoprefixer())
    .pipe(gulp.dest('./public/css'))
})

gulp.task('autocss', function() {
  gulp.watch('./public/src/sass/*.scss', ['css'])
})

gulp.task('imagemin', function() {
  return gulp.src('./public/src/images/*.png')
    .pipe(imagemin())
    .pipe(gulp.dest('./public/images'));
})

gulp.task('autoimagemin', function() {
  gulp.watch('./public/src/images/*', ['imagemin'])
})

gulp.task('default', ['css', 'autocss'])
