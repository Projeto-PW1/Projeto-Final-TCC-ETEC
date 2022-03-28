import { View, TextInput, TouchableOpacity, Text, Alert, ImageBackground } from "react-native";

import styles from "../styles/Slogin";

export default function Login() {
  return (
    <View style={styles.container}>
      <ImageBackground
        source={require("../images/imgbg.jpg")}
        style={styles.image}
        resizeMode={"cover"}
        blurRadius={1}
      >
        <View style={styles.container2}>
          <Text style={styles.title}>Login</Text>

          <TextInput
            style={styles.input}
            placeholder="Digite seu email"
            multiline={false}
          />

          <TextInput
            style={styles.input}
            placeholder="Digite sua senha"
            secureTextEntry={true}
          />

          <TouchableOpacity
            style={styles.botao}
            onPress={() => {
              Alert.alert("Tudo certo", "Login efetuado com sucesso!!");
            }}
          >
            <Text>Entrar</Text>
          </TouchableOpacity>
        </View>
      </ImageBackground>
    </View>
  );
}
