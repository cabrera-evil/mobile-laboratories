package com.example.laboratorio11

import com.example.laboratorio11.network.dto.login.LoginRequest
import com.example.laboratorio11.network.service.AuthService
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var authService: AuthService

    @Before//Antes de cada prueba
    fun setup() {

        mockWebServer = MockWebServer()

        authService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()//construir retrofit
            .create(AuthService::class.java)
    }

    @Test//Prueba unitaria
    fun loginTest() = runTest{
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody("""{"msg": "Login succesful", "token":"testToken"}""")

        mockWebServer.enqueue(mockResponse)

        val response = authService.login(LoginRequest("admin", "admin"))

        mockWebServer.takeRequest()

        Assert.assertEquals("Login succesful", response.message)
        Assert.assertEquals("testToken", response.token)
    }

    @Test//Prueba unitaria
    fun unsuccesfulLogin() = runTest{
        val mockResponse = MockResponse()
            .setBody("""{"msg": "Check credentials"}""")

        mockWebServer.enqueue(mockResponse)
        val response = authService.login(LoginRequest("admin", "admin"))

        mockWebServer.takeRequest()//tomar la peticion

        Assert.assertEquals("Check credentials", response.message)
    }

    @After//Despues de cada prueba
    fun tearDown(){
        mockWebServer.shutdown()//detener el servidor
    }
}