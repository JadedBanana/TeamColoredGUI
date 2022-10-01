# Set -e so if errors occur we're fine
set -e

# Set variables
HIGH_FACTOR_LIGHT=1
LOW_FACTOR_LIGHT=-5
HIGH_FACTOR_MID=1
LOW_FACTOR_MID=-6
HIGH_FACTOR_DARK=1
LOW_FACTOR_DARK=-5.5

# black
echo -e "Generating BLACK spectral arrow image..."
python3 image_color_replace_by_value.py spectral_arrow/full.png "(12,12,12)" "(5,5,5)" 1 0
cp spectral_arrow/full.png ../src/main/resources/assets/teamindicatorsplus/textures/entity/projectiles/black_spectral_arrow.png

# dark blue
echo -e "Generating DARK BLUE spectral arrow image..."
python3 image_color_replace_by_value.py spectral_arrow/full.png "(0,0,168)" "(0,0,41)" $HIGH_FACTOR_DARK $LOW_FACTOR_DARK
cp spectral_arrow/full.png ../src/main/resources/assets/teamindicatorsplus/textures/entity/projectiles/dark_blue_spectral_arrow.png

# dark green
echo -e "Generating DARK GREEN spectral arrow image..."
python3 image_color_replace_by_value.py spectral_arrow/full.png "(0,168,0)" "(0,41,0)" $HIGH_FACTOR_DARK $LOW_FACTOR_DARK
cp spectral_arrow/full.png ../src/main/resources/assets/teamindicatorsplus/textures/entity/projectiles/dark_green_spectral_arrow.png

# dark aqua
echo -e "Generating DARK AQUA spectral arrow image..."
python3 image_color_replace_by_value.py spectral_arrow/full.png "(0,168,168)" "(0,41,41)" $HIGH_FACTOR_DARK $LOW_FACTOR_DARK
cp spectral_arrow/full.png ../src/main/resources/assets/teamindicatorsplus/textures/entity/projectiles/black_spectral_arrow.png
merge_images dark_aqua

# dark red
echo -e "Generating DARK RED spectral arrow image..."
python3 image_color_replace_by_value.py spectral_arrow/full.png "(168,0,0)" "(41,0,0)" $HIGH_FACTOR_DARK $LOW_FACTOR_DARK
cp spectral_arrow/full.png ../src/main/resources/assets/teamindicatorsplus/textures/entity/projectiles/dark_red_spectral_arrow.png

# dark purple
echo -e "Generating DARK PURPLE spectral arrow image..."
python3 image_color_replace_by_value.py spectral_arrow/full.png "(168,0,168)" "(41,0,41)" $HIGH_FACTOR_DARK $LOW_FACTOR_DARK
cp spectral_arrow/full.png ../src/main/resources/assets/teamindicatorsplus/textures/entity/projectiles/dark_purple_spectral_arrow.png

# gold
echo -e "Generating GOLD spectral arrow image..."
python3 image_color_replace_by_value.py spectral_arrow/full.png "(252,168,0)" "(62,41,0)" $HIGH_FACTOR_DARK $LOW_FACTOR_DARK
cp spectral_arrow/full.png ../src/main/resources/assets/teamindicatorsplus/textures/entity/projectiles/gold_spectral_arrow.png

# gray
echo -e "Generating GRAY spectral arrow image..."
python3 image_color_replace_by_value.py spectral_arrow/full.png "(168,168,168)" "(41,41,41)" $HIGH_FACTOR_DARK $LOW_FACTOR_DARK
cp spectral_arrow/full.png ../src/main/resources/assets/teamindicatorsplus/textures/entity/projectiles/gray_spectral_arrow.png

# dark gray
echo -e "Generating DARK GRAY spectral arrow image..."
python3 image_color_replace_by_value.py spectral_arrow/full.png "(84,84,84)" "(21,21,21)" $HIGH_FACTOR_DARK $LOW_FACTOR_DARK
cp spectral_arrow/full.png ../src/main/resources/assets/teamindicatorsplus/textures/entity/projectiles/dark_gray_spectral_arrow.png

# blue
echo -e "Generating BLUE spectral arrow image..."
python3 image_color_replace_by_value.py spectral_arrow/full.png "(84,84,252)" "(21,21,62)" $HIGH_FACTOR_MID $LOW_FACTOR_MID
cp spectral_arrow/full.png ../src/main/resources/assets/teamindicatorsplus/textures/entity/projectiles/blue_spectral_arrow.png

# green
echo -e "Generating GREEN spectral arrow image..."
python3 image_color_replace_by_value.py spectral_arrow/full.png "(84,252,84)" "(21,62,21)" $HIGH_FACTOR_MID $LOW_FACTOR_MID
cp spectral_arrow/full.png ../src/main/resources/assets/teamindicatorsplus/textures/entity/projectiles/green_spectral_arrow.png

# aqua
echo -e "Generating AQUA spectral arrow image..."
python3 image_color_replace_by_value.py spectral_arrow/full.png "(84,252,252)" "(21,62,62)" $HIGH_FACTOR_MID $LOW_FACTOR_MID
cp spectral_arrow/full.png ../src/main/resources/assets/teamindicatorsplus/textures/entity/projectiles/aqua_spectral_arrow.png

# red
echo -e "Generating RED spectral arrow image..."
python3 image_color_replace_by_value.py spectral_arrow/full.png "(251,84,84)" "(62,21,21)" $HIGH_FACTOR_MID $LOW_FACTOR_MID
cp spectral_arrow/full.png ../src/main/resources/assets/teamindicatorsplus/textures/entity/projectiles/red_spectral_arrow.png

# light purple
echo -e "Generating LIGHT PURPLE spectral arrow image..."
python3 image_color_replace_by_value.py spectral_arrow/full.png "(252,84,252)" "(62,21,62)" $HIGH_FACTOR_MID $LOW_FACTOR_MID
cp spectral_arrow/full.png ../src/main/resources/assets/teamindicatorsplus/textures/entity/projectiles/light_purple_spectral_arrow.png

# yellow
echo -e "Generating YELLOW spectral arrow image..."
python3 image_color_replace_by_value.py spectral_arrow/full.png "(252,252,84)" "(62,62,21)" $HIGH_FACTOR_MID $LOW_FACTOR_MID
cp spectral_arrow/full.png ../src/main/resources/assets/teamindicatorsplus/textures/entity/projectiles/yellow_spectral_arrow.png

# white
echo -e "Generating WHITE spectral arrow image..."
python3 image_color_replace_by_value.py spectral_arrow/full.png "(252,252,252)" "(62,62,62)" $HIGH_FACTOR_LIGHT $LOW_FACTOR_LIGHT
cp spectral_arrow/full.png ../src/main/resources/assets/teamindicatorsplus/textures/entity/projectiles/white_spectral_arrow.png
