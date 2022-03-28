import {
  View,
  TextInput,
  TouchableOpacity,
  Text,
  Alert,
  ImageBackground,
} from "react-native";

import styles from "../styles/SCadastro";

export default function Cadastro() {
  return (
    <View style={styles.container}>
      <ImageBackground
        source={require("../images/imgbg.jpg")}
        style={styles.image}
        resizeMode={"cover"}
        blurRadius={1}
      >
        <View style={styles.container2}>
          <Text style={styles.title}>Cadastro</Text>

          <TextInput
            style={styles.input}
            placeholder="Digite seu nome"
          />

          <TextInput
            style={styles.input}
            placeholder="Digite seu email"
          />

          <TextInput
            style={styles.input}
            placeholder="Digite sua senha"
            secureTextEntry={true}
          />

          <TextInput
            style={styles.input}
            placeholder="Confirme sua senha"
            secureTextEntry={true}
          />

          <View style={styles.viewB}>
          <TouchableOpacity
            style={styles.botao2}
            onPress={() => {
              Alert.alert("Tudo certo", "Cadastro efetuado com sucesso!!");
            }}
          >
            <Text style={styles.text2}>Já tem uma conta?</Text>
          </TouchableOpacity>
          </View>

          <TouchableOpacity
            style={styles.botao}
            onPress={() => {
              Alert.alert("Tudo certo", "Cadastro efetuado com sucesso!!");
            }}
          >
            <Text style={styles.text}>Cadastrar</Text>
          </TouchableOpacity>
        </View>
      </ImageBackground>
    </View>
  );
}
