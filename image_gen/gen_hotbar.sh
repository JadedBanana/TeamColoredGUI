# Function to merge the generated images together.
merge_images() {
	composite -compose over -alpha On hotbar/inside_post.png hotbar/border.png ../src/main/resources/assets/teamindicatorsplus/textures/gui/$1_widgets.png
	composite -compose over -alpha On ../src/main/resources/assets/teamindicatorsplus/textures/gui/$1_widgets.png hotbar/bg.png ../src/main/resources/assets/teamindicatorsplus/textures/gui/$1_widgets.png
	composite -compose over -alpha On ../src/main/resources/assets/teamindicatorsplus/textures/gui/$1_widgets.png hotbar/selector.png ../src/main/resources/assets/teamindicatorsplus/textures/gui/$1_widgets.png
}

# Set -e so if errors occur we're fine
set -e

# Set variables
HIGH_FACTOR=0.5
LOW_FACTOR=0

# black
echo -e "Generating BLACK hotbar image..."
python3 scripts/image_color_replace_by_value.py hotbar/inside.png "(32,32,32)" "(8,8,8)" $HIGH_FACTOR $LOW_FACTOR
merge_images black

# dark blue
echo -e "Generating DARK BLUE hotbar image..."
python3 scripts/image_color_replace_by_value.py hotbar/inside.png "(0,0,168)" "(0,0,41)" $HIGH_FACTOR $LOW_FACTOR
merge_images dark_blue

# dark green
echo -e "Generating DARK GREEN hotbar image..."
python3 scripts/image_color_replace_by_value.py hotbar/inside.png "(0,168,0)" "(0,41,0)" $HIGH_FACTOR $LOW_FACTOR
merge_images dark_green

# dark aqua
echo -e "Generating DARK AQUA hotbar image..."
python3 scripts/image_color_replace_by_value.py hotbar/inside.png "(0,168,168)" "(0,41,41)" $HIGH_FACTOR $LOW_FACTOR
merge_images dark_aqua

# dark red
echo -e "Generating DARK RED hotbar image..."
python3 scripts/image_color_replace_by_value.py hotbar/inside.png "(168,0,0)" "(41,0,0)" $HIGH_FACTOR $LOW_FACTOR
merge_images dark_red

# dark purple
echo -e "Generating DARK PURPLE hotbar image..."
python3 scripts/image_color_replace_by_value.py hotbar/inside.png "(168,0,168)" "(41,0,41)" $HIGH_FACTOR $LOW_FACTOR
merge_images dark_purple

# gold
echo -e "Generating GOLD hotbar image..."
python3 scripts/image_color_replace_by_value.py hotbar/inside.png "(252,168,0)" "(62,41,0)" $HIGH_FACTOR $LOW_FACTOR
merge_images gold

# gray
echo -e "Generating GRAY hotbar image..."
python3 scripts/image_color_replace_by_value.py hotbar/inside.png "(168,168,168)" "(41,41,41)" $HIGH_FACTOR $LOW_FACTOR
merge_images gray

# dark gray
echo -e "Generating DARK GRAY hotbar image..."
python3 scripts/image_color_replace_by_value.py hotbar/inside.png "(84,84,84)" "(21,21,21)" $HIGH_FACTOR $LOW_FACTOR
merge_images dark_gray

# blue
echo -e "Generating BLUE hotbar image..."
python3 scripts/image_color_replace_by_value.py hotbar/inside.png "(84,84,252)" "(21,21,62)" $HIGH_FACTOR $LOW_FACTOR
merge_images blue

# green
echo -e "Generating GREEN hotbar image..."
python3 scripts/image_color_replace_by_value.py hotbar/inside.png "(84,252,84)" "(21,62,21)" $HIGH_FACTOR $LOW_FACTOR
merge_images green

# aqua
echo -e "Generating AQUA hotbar image..."
python3 scripts/image_color_replace_by_value.py hotbar/inside.png "(84,252,252)" "(21,62,62)" $HIGH_FACTOR $LOW_FACTOR
merge_images aqua

# red
echo -e "Generating RED hotbar image..."
python3 scripts/image_color_replace_by_value.py hotbar/inside.png "(251,84,84)" "(62,21,21)" $HIGH_FACTOR $LOW_FACTOR
merge_images red

# light purple
echo -e "Generating LIGHT PURPLE hotbar image..."
python3 scripts/image_color_replace_by_value.py hotbar/inside.png "(252,84,252)" "(62,21,62)" $HIGH_FACTOR $LOW_FACTOR
merge_images light_purple

# yellow
echo -e "Generating YELLOW hotbar image..."
python3 scripts/image_color_replace_by_value.py hotbar/inside.png "(252,252,84)" "(62,62,21)" $HIGH_FACTOR $LOW_FACTOR
merge_images yellow

# white
echo -e "Generating WHITE hotbar image..."
python3 scripts/image_color_replace_by_value.py hotbar/inside.png "(252,252,252)" "(62,62,62)" $HIGH_FACTOR $LOW_FACTOR
merge_images white
