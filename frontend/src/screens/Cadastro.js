//Importando Componentes do React-Native
import {
  View,
  TouchableOpacity,
  Text,
  ImageBackground,
  StatusBar,
  Alert,
} from "react-native";
import React, { useState } from "react";

//Importação React-Hook-Form
import { useForm, Controller } from "react-hook-form";
//Importando Yup
import { yupResolver } from "@hookform/resolvers/yup";
import * as yup from "yup";

//Importando caixa de texto do React Native Elements
import { Input } from "react-native-elements";
//Importando Ícones do MaterialIcons do react-native-vector-icons
import Icon from "react-native-vector-icons/MaterialIcons";
//Importando styles
import styles from "../styles/SCadastro";

//API
import api from "../api/Api";

export default function Cadastro({ navigation }) {
  //Validando o formulário e exibindo mensagens de erro com Yup
  const schema = yup.object({
    nome: yup
      .string()
      .required("Digite seu nome")
      .min(3, "O nome deve ter pelo menos 3 caracteres")
      .matches(/^[aA-zZ 0-9\s]+$/, "O nome não pode ter caracteres especiais")
      .max(70, "O nome deve ter no máximo 70 caracteres"),
    login: yup.string().email("Email inválido").required("Digite seu email"),
    senha: yup
      .string()
      .min(6, "A senha deve ter pelo menos 6 caracteres")
      .max(24, "A senha deve ter no máximo 24 caracteres")
      .required("Digite uma senha"),
    confirmarSenha: yup
      .string()
      .oneOf([yup.ref("senha"), null], "As senhas não são iguais"),
  });

  const {
    control,
    handleSubmit,
    formState: { errors },
  } = useForm({
    resolver: yupResolver(schema), //Falando pro React-Hook-Form que a validação vai ser pelo Yup
  });

  //Conexão com a api
  const onSubmit = async (data) => {
    try {
      const response = await api.post("/usuarios/save", data);

      console.log("esse daq", response.data);


      if (response.status === 200) {
        Alert.alert("Sucesso", "Cadastro efetuado com sucesso!!")
        navigation.navigate('Login')
      } else {
        throw new Error("Erro desconhecido.")
      }
    } catch (err) {
      Alert.alert("Erro", "deu ruim");
    }
  };

  //Mostrar ou ocultar a senha
  const [mostrarSenha, setMostrarSenha] = useState(true);
  const [mostrarSenha2, setMostrarSenha2] = useState(true);

  return (
    <View style={styles.container}>
      <StatusBar
        barStyle="dark-content"
        hidden={true}
        translucent={true}
        backgroundColor={"white"}
      />
      <ImageBackground
        source={require("../images/fundo000.png")}
        style={styles.image}
        resizeMode={"cover"}
        blurRadius={1}
      >
        <View style={styles.container2}>
          <Text style={styles.title}>Cadastro</Text>

          <Controller
            control={control}
            name={"nome"}
            render={({ field: { onChange, value } }) => (
              <Input
                style={styles.input}
                placeholder="Digite seu nome"
                placeholderTextColor="black"
                autoCapitalize="none"
                value={value}
                onChangeText={onChange}
                leftIcon={<Icon name="person" color="black" size={24} />}
              />
            )}
          />
          {errors.nome && (
            <Text style={styles.inputError}>{errors.nome?.message}</Text>
          )}

          <Controller
            control={control}
            name={"login"}
            render={({ field: { onChange, value } }) => (
              <Input
                style={styles.input}
                placeholder="Digite seu email"
                placeholderTextColor="black"
                autoCapitalize="none"
                keyboardType="email-address"
                value={value}
                onChangeText={onChange}
                leftIcon={<Icon name="email" color="black" size={24} />}
              />
            )}
          />

          {errors.login && (
            <Text style={styles.inputError}>{errors.login?.message}</Text>
          )}

          <View style={styles.viewInput}>
            <Controller
              control={control}
              name={"senha"}
              render={({ field: { onChange, value } }) => (
                <Input
                  style={styles.input}
                  placeholder="Digite sua senha"
                  placeholderTextColor="black"
                  autoCapitalize="none"
                  secureTextEntry={mostrarSenha}
                  value={value}
                  onChangeText={onChange}
                  leftIcon={<Icon name="lock" color="black" size={24} />}
                />
              )}
            />
            <TouchableOpacity onPress={() => setMostrarSenha(!mostrarSenha)}>
              <Icon name="visibility" color="black" size={25} />
            </TouchableOpacity>
          </View>
          {errors.senha && (
            <Text style={styles.inputError}>{errors.senha?.message}</Text>
          )}

          <View style={styles.viewInput}>
            <Controller
              control={control}
              name={"confirmarSenha"}
              render={({ field: { onChange, value } }) => (
                <Input
                  style={styles.input}
                  placeholder="Digite sua senha"
                  placeholderTextColor="black"
                  autoCapitalize="none"
                  secureTextEntry={mostrarSenha2}
                  value={value}
                  onChangeText={onChange}
                  leftIcon={<Icon name="lock" color="black" size={24} />}
                />
              )}
            />
            <TouchableOpacity onPress={() => setMostrarSenha2(!mostrarSenha2)}>
              <Icon name="visibility" color="black" size={25} />
            </TouchableOpacity>
          </View>
          {errors.confirmarSenha && (
            <Text style={styles.inputError}>
              {errors.confirmarSenha?.message}
            </Text>
          )}

          <TouchableOpacity
            style={styles.botao}
            onPress={handleSubmit(onSubmit)}
          >
            <Text style={styles.text}>Cadastrar</Text>
          </TouchableOpacity>

          <View style={styles.viewB}>
            <TouchableOpacity
              style={styles.botao2}
              onPress={() => {
                navigation.navigate("Login");
              }}
            >
              <Text style={styles.text2}>Já possui uma conta?</Text>
            </TouchableOpacity>
          </View>
        </View>
      </ImageBackground>
    </View>
  );
}
