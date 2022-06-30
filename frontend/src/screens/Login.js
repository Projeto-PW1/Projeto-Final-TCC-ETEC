//Importando Componentes do React-Native
import {
  View,
  TouchableOpacity,
  Text,
  Alert,
  ImageBackground,
  StatusBar,
} from "react-native";

import React, { useEffect, useState } from "react";

//Importação React-Hook-Form
import { useForm, Controller } from "react-hook-form";

//Importando Yup
import { yupResolver } from "@hookform/resolvers/yup";
import * as yup from "yup";

//Importando caixa de texto do React Native Elements
import { Input } from "react-native-elements";
//Importando styles
import styles from "../styles/Slogin";
//Importando Ícones do MaterialIcons do react-native-vector-icons
import Icon from "react-native-vector-icons/MaterialIcons";

//API
import api from "../api/Api";
import AsyncStorage from "@react-native-async-storage/async-storage";

export default function Login({ navigation }) {
  //Validação com Yup
  const schema = yup.object({
    email: yup.string().email("Email inválido").required("Digite seu email"),
    senha: yup.string().required("Digite sua senha"),
  });

  const {
    control,
    handleSubmit,
    formState: { errors },
  } = useForm({
    resolver: yupResolver(schema),
  });

  //Conexão com a api
  const onSubmit = async (data) => {
    api
      .post("/login", {
        login: data.email,
        senha: data.senha,
      })

      .then(async (response) => {
        await AsyncStorage.setItem("token", response.data.Authorization);
        //console.log(response.data.Authorization);

        if (response.status == 200) {
          console.log(response.data);
          await AsyncStorage.setItem("email", data.email);
          navigation.navigate("Home");
        } else {
          throw new Error("Erro desconhecido.");
        }
      })
      .catch((e) => {
        Alert.alert("Erro", "Usuário ou senha inválidos");
        console.log(e);
      });
  };

  //Mostrar ou ocultar a senha
  const [mostrarSenha, setMostrarSenha] = useState(true);

  return (
    <View style={styles.container}>
      <StatusBar
        barStyle="dark-content"
        hidden={true}
        translucent={true}
        backgroundColor={"white"}
      />
      <ImageBackground
        source={require("../images/fundo00.png")}
        style={styles.image}
        resizeMode={"cover"}
        blurRadius={1}
      >
        <View style={styles.container2}>
          <Text style={styles.title}>Login</Text>

          <Controller
            control={control}
            name={"email"}
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
          {errors.email && (
            <Text style={styles.inputError}>{errors.email?.message}</Text>
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

          <TouchableOpacity
            style={styles.botao}
            onPress={handleSubmit(onSubmit)}
          >
            <Text style={styles.text}>Entrar</Text>
          </TouchableOpacity>

          <View style={styles.viewB}>
            <TouchableOpacity
              style={styles.botao2}
              onPress={() => {
                navigation.navigate("Cadastro");
              }}
            >
              <Text style={styles.text2}>Não possui cadastro?</Text>
            </TouchableOpacity>
          </View>
        </View>
      </ImageBackground>
    </View>
  );
}
